package com.mirketa;


class PT implements Serializable  {
  def apiToken

  PT(token){
  	this.apiToken=token
  }

  void getToken(){
  	println apiToken
  }
}
