package com.mirketa;


class PT implements Serializable  {
  def apiToken
  @NonCPS
  PT(token){
  	this.apiToken=token
  }
  @NonCPS
  void getToken(){
  	println apiToken
  }
}
