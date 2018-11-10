package com.rtjvm.scala.oop.filesystem

import com.rtjvm.scala.oop.files.Directory

class State(val root: Directory, val wd: Directory, val output: String) {
  //  output of previous command

  def show =  {
    println(output)
    print(State.TOKEN)
  }

  def setMessage(message: String): State = State(root, wd, message)
}

object State {
  val TOKEN = "$ "

  def apply(root: Directory, wd: Directory, output: String = "") =
    new State(root, wd, output)
}