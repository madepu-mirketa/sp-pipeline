package com.mirketa;


class PivotalTracker implements Serializable  {
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
