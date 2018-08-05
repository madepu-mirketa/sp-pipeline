package com.mirketa;
import java.net.URLEncoder
import groovy.json.JsonSlurper


class PT{
    def apiToken=''

    PT(token){
               apiToken = token
    }

    def getStories(script,pt_project_id,pt_state='',pt_label='',pt_update_after=''){
        if(apiToken.equals("")){
            echo "Please set Jenkins credentials with pt_api_token"
            retun
        }
        def storyIds, labels, branches

        def storiesPathTemplate = "projects/%s/stories"
        def storiesLabelPathTemplate = "projects/%s/stories/%s/labels"
        def storyPathTemplate = "projects/%s/stories/%s"

        def base ="https://www.pivotaltracker.com/services/v5/"

        def storiesPath=String.format(storiesPathTemplate,pt_project_id)

        def query='?fields=current_state%2Clabels%2Cbranches%2Ctasks&date_format=millis&filter='
        if(!pt_state.equals("")){
            pt_state=pt_state.replaceAll(',',' OR state:')
            pt_state=pt_state.replaceFirst('^','state:')
            query=query+URLEncoder.encode(pt_state, "UTF-8").replaceAll('\\+','%20')
            query=query+'&with_state='+pt_state
        }
        if(!pt_update_after.equals("")){
            pt_update_after=pt_update_after.replaceFirst('^','updated_after:')
            query=query+URLEncoder.encode(pt_update_after, "UTF-8").replaceAll('\\+','%20')
        }
        if(!pt_label.equals("")){
            pt_label=pt_label.replaceAll(',',' AND label:')
            pt_label=pt_label.replaceFirst('^','label:')
            query=query+URLEncoder.encode(pt_label, "UTF-8").replaceAll('\\+','%20')
        }

        def pt_url=base + storiesPath + query
        def headers=[maskValue: true, name: 'X-TrackerToken', value: apiToken]

        def response = script.httpRequest acceptType: 'APPLICATION_JSON', contentType: 'APPLICATION_JSON', customHeaders: [headers], responseHandle: 'LEAVE_OPEN', url: pt_url
        //println('Status: '+response.status)
        //println('Response: '+response.content)

        def json = new JsonSlurper().parseText(response.content)
        storyIds=json*.id
        //echo "storyIds: ${storyIds}"
        labels=json*.labels.name
        //echo "labels: ${labels}"
        branches=json*.branches.name
        //echo "branches: ${branches}"
        return [storyIds,labels,branches]
    }
}
