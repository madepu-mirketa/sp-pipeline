package com.mirketa


class PivotalTracker {
  def apiToken
  PivotalTracker(token){
  	this.apiToken=token
  }
  void getToken(){
  	println apiToken
  }
}

return this