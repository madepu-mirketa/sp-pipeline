package com.mirketa;


class PT implements Serializable  {
  def apiToken
  @NonCPS
  PivotalTracker(token){
  	this.apiToken=token
  }
  @NonCPS
  void getToken(){
  	println apiToken
  }
}
