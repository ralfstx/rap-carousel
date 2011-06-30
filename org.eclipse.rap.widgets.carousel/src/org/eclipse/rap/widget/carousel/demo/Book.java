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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;


public class Book {

  private static final String BUNDLE_ID = "org.eclipse.rap.widget.carousel";
  
  private String title;
  private String url;
  private int imgNumber;

  public Book( String title, String url, int imgNumber ) {
    this.title = title;
    this.url = url;
    this.imgNumber = imgNumber;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getUrl() {
    return url;
  }
  
  public Image getCover() {
    return createImage( "images/" + imgNumber + ".png" );
  }
  
  private Image createImage( String imagePath ) {
    ImageDescriptor imageDescriptor 
      = AbstractUIPlugin.imageDescriptorFromPlugin( BUNDLE_ID, imagePath );
    return imageDescriptor.createImage();
  }
  
}
