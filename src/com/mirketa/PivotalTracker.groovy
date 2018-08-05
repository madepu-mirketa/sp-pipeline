package com.mirketa;


class PivotalTracker implements Serializable  {
  def apiToken
  PivotalTracker(token){
  	this.apiToken=token
  }
  void getToken(){
  	println apiToken
  }
}
