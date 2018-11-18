package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.Directory
import com.rtjvm.scala.oop.filesystem.State

class Mkdir(val name: String) extends Command {
  def apply(state: State) =
    if (state.wd.hasEntry(name))
      state.setMessage(name + " already exists with this name.")
    else if (name.contains(Directory.SEPARATOR))
      state.setMessage( name + ": name must not contain separator!")
    else if (name.contains("."))
      state.setMessage(name + ": Illegal name!")
    else
      doMkdir(name, state)

  def doMkdir(name: String, state: State): State = ???



}
