package com.mirketa;


class PT{
  def apiToken

  PT(token){
  	apiToken=token
  }

  def getToken(){
  	println apiToken
  	return apiToken
  }
}
