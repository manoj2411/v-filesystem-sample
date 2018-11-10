package com.rtjvm.scala.oop.files

class Directory(override val parentPath: String, override val name: String, val contents: List[DirEntry])
      extends DirEntry(parentPath, name)

object Directory {
  val SEPARATOR = "/"
  val ROOT_PATH = "/"

  def ROOT = empty("", "")

  def empty(pathName: String, name: String) = new Directory(pathName, name, List())
}
