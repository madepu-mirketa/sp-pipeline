package com.mirketa;


class PT{
  def apiToken

  PT(token){
  	apiToken=token
  }

  getToken(){
  	println apiToken
  	return apiToken
  }
}
