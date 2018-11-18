package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

trait Command {
  def apply(state: State): State
}

object Command {
  val MKDIR = "mkdir"

  def emptyMethod: Command = new Command {
    override def apply(state: State) = state
  }

  def incompleteMethod(name: String): Command = new Command {
    def apply(state: State) = state.setMessage(name + ": incompatible command!")
  }


  def from(input: String): Command = {
    val tokens = input.split(" ")

    if (input.isEmpty ||tokens.isEmpty) emptyMethod
    else if (tokens(0).equals(MKDIR))
      if (tokens.length < 2 ) incompleteMethod(tokens(0))
      else new Mkdir(tokens(1))
    else new UnknownCommand
  }
}