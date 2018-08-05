package com.mirketa


class PivotalTracker implements Serializable  {
  def apiToken
  PivotalTracker(script,token){
  	this.apiToken=token
  }
  void getToken(script){
  	println apiToken
  }
}
