package org.eclipse.rap.demo.gmaps.internal;

import org.eclipse.rap.examples.IExampleContribution;
import org.eclipse.rap.examples.IExamplePage;


final class CarouselExampleContribution implements IExampleContribution {

  public String getId() {
    return "carousel";
  }

  public String getTitle() {
    return "JQuery Carousel";
  }

  public IExamplePage createPage() {
    return new CarouselExamplePage();
  }
}
