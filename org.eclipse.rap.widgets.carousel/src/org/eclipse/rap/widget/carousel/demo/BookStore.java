/******************************************************************************* 
* Copyright (c) 2010, 2011 EclipseSource and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    EclipseSource - initial API and implementation
*******************************************************************************/ 
package org.eclipse.rap.widget.carousel.demo;


public class BookStore {
  
  private Book[] books;

  public BookStore() {
    books = new Book[] {
      new Book( "Clean Code: A Handbook of Agile Software Craftsmanship", "http://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882/ref=sr_1_1?ie=UTF8&qid=1291743762&sr=8-1", 1 ),
      new Book( "The Pragmatic Programmer: From Journeyman to Master", "http://www.amazon.com/Pragmatic-Programmer-Journeyman-Master/dp/020161622X/ref=pd_bxgy_b_img_b", 2 ),
      new Book( "Refactoring: Improving the Design of Existing Code", "http://www.amazon.com/Refactoring-Improving-Design-Existing-Code/dp/0201485672/ref=pd_bxgy_b_img_c", 3 ),
      new Book( "Design Patterns: Elements of Reusable Object-Oriented Software", "http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612/ref=pd_bxgy_b_img_b", 4 ),
      new Book( "Effective Java (2nd Edition)", "http://www.amazon.com/Effective-Java-2nd-Joshua-Bloch/dp/0321356683/ref=sr_1_1?s=books&ie=UTF8&qid=1291744460&sr=1-1", 5 ),
      new Book( "Java Concurrency in Practice", "http://www.amazon.com/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601/ref=pd_bxgy_b_img_b", 6 ),
      new Book( "OSGi and Equinox: Creating Highly Modular Java Systems", "http://www.amazon.com/OSGi-Equinox-Creating-Modular-Systems/dp/0321585712/ref=sr_1_1?s=books&ie=UTF8&qid=1291744584&sr=1-1", 7 ),
      new Book( "Test Driven Development: By Example", "http://www.amazon.com/Test-Driven-Development-Kent-Beck/dp/0321146530/ref=sr_1_1?s=books&ie=UTF8&qid=1291744652&sr=1-1", 8 )
    };
  }

  public Book[] getBooks() {
    return books;
  }
  
}
