/*******************************************************************************
 * Copyright (c) 2011 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package org.eclipse.rap.demo.gmaps.internal;

import org.eclipse.rap.examples.ExampleUtil;
import org.eclipse.rap.examples.IExamplePage;
import org.eclipse.rap.widget.carousel.Carousel;
import org.eclipse.rap.widget.carousel.CarouselItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;


public class CarouselExamplePage implements IExamplePage {

  private final BookStore store;
  private Label bookTitle;
  private Browser bookBrowser;

  public CarouselExamplePage() {
    store = new BookStore();
  }

  public void createControl( Composite parent ) {
    parent.setLayout( ExampleUtil.createMainLayout( 1 ) );
    Group group = new Group( parent, SWT.NONE );
    group.setText( "JQuery UI Carousel Widget" );
    FormLayout layout = new FormLayout();
    layout.marginWidth = 10;
    layout.marginHeight = 10;
    group.setLayout( layout );
    group.setLayoutData( ExampleUtil.createFillData() );
    Carousel carousel = new Carousel( group );
    addBooks( carousel, 8 );
    layoutCarousel( carousel );
    createControls( group, carousel );
    carousel.render();
  }

  private void layoutCarousel( Carousel carousel ) {
    FormData fdCarousel = new FormData();
    carousel.setLayoutData( fdCarousel );
    fdCarousel.left = new FormAttachment( 0 );
    fdCarousel.top = new FormAttachment( 0 );
    fdCarousel.right = new FormAttachment( 100 );
    fdCarousel.height = 200;
  }

  private void createControls( Composite parent, Carousel carousel ) {
    Label description = new Label( parent, SWT.NONE );
    description.setText( "Last title clicked:" );
    FormData fdLabel = new FormData();
    description.setLayoutData( fdLabel );
    fdLabel.left = new FormAttachment( 0 );
    fdLabel.top = new FormAttachment( carousel, 10 );
    bookTitle = new Label( parent, SWT.NONE );
    bookTitle.setText( "none" );
    FormData fdBookTitle = new FormData();
    bookTitle.setLayoutData( fdBookTitle );
    fdBookTitle.left = new FormAttachment( description, 5 );
    fdBookTitle.top = fdLabel.top;
    fdBookTitle.right = new FormAttachment( 100 );
    bookBrowser = new Browser( parent, SWT.NONE );
    FormData fdBookBrowser = new FormData();
    bookBrowser.setLayoutData( fdBookBrowser );
    fdBookBrowser.top = new FormAttachment( description, 10 );
    fdBookBrowser.left = new FormAttachment( 0 );
    fdBookBrowser.right = new FormAttachment( 100 );
    fdBookBrowser.bottom = new FormAttachment( 100 );
  }

  private void addBooks( Carousel parent, int count ) {
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
}
