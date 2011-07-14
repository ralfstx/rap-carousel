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

import org.eclipse.rap.widget.carousel.Carousel;
import org.eclipse.rap.widget.carousel.CarouselItem;
import org.eclipse.rwt.lifecycle.IEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class BookDemo implements IEntryPoint {
  
  private Label bookTitle;
  private BookStore store;
  private Browser bookBrowser;

  public BookDemo() {
    store = new BookStore();
  }

  public int createUI() {
    Display display = new Display();
    Shell shell = new Shell( display );
    shell.setBounds( 10, 10, 800, 600 );
    shell.setText( "Bookstore Demo" );
    shell.setLayout( new FormLayout() );
    Carousel carousel = new Carousel( shell );
    layoutCarousel( carousel );
    addBooks( carousel );
    createControls( shell, carousel );
    carousel.render();   
    shell.open();
    runReadAndDispatchLoop( shell );
    return 0;
  }

  private void layoutCarousel( Carousel carousel ) {
    FormData fdCarousel = new FormData();
    carousel.setLayoutData( fdCarousel );
    fdCarousel.left = new FormAttachment( 0 );
    fdCarousel.top = new FormAttachment( 0 );
    fdCarousel.right = new FormAttachment( 100 );
    fdCarousel.height = 200;
  }

  private void createControls( Shell shell, Carousel carousel ) {
    Label description = new Label( shell, SWT.NONE );
    description.setText( "Last title clicked:" );
    FormData fdLabel = new FormData();
    description.setLayoutData( fdLabel );
    fdLabel.left = new FormAttachment( 0 );
    fdLabel.top = new FormAttachment( carousel, 10 );
    bookTitle = new Label( shell, SWT.NONE );
    bookTitle.setText( "none" );
    FormData fdBookTitle = new FormData();
    bookTitle.setLayoutData( fdBookTitle );
    fdBookTitle.left = new FormAttachment( description, 5 );
    fdBookTitle.top = fdLabel.top;
    fdBookTitle.right = new FormAttachment( 100 );
    bookBrowser = new Browser( shell, SWT.NONE );
    FormData fdBookBrowser = new FormData();
    bookBrowser.setLayoutData( fdBookBrowser );
    fdBookBrowser.top = new FormAttachment( description, 10 );
    fdBookBrowser.left = new FormAttachment( 0 );
    fdBookBrowser.right = new FormAttachment( 100 );
    fdBookBrowser.bottom = new FormAttachment( 100 );
  }

  private void addBooks( Carousel parent ) {
    Book[] books = store.getBooks();
    for( int i = 0; i < books.length; i++ ) {
      Book book = books[ i ];
      CarouselItem item = new CarouselItem( parent, book.getCover() );
      addSelectionListenerToItem( item, book );
    }
  }

  private void addSelectionListenerToItem( CarouselItem item, final Book book ) {
    item.addSelectionListener( new SelectionAdapter() {
      @Override
      public void widgetSelected( SelectionEvent e ) {
        bookTitle.setText( book.getTitle() );
        bookBrowser.setUrl( book.getUrl() );
      }
    } );
  }

  private void runReadAndDispatchLoop( Shell shell ) {
    while( !shell.isDisposed() ) {
      if( !shell.getDisplay().readAndDispatch() ) {
        shell.getDisplay().sleep();
      }
    }
  }
}
