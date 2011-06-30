/******************************************************************************* 
* Copyright (c) 2010 EclipseSource and others. All rights reserved. This
* program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution, and is
* available at http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   EclipseSource - initial API and implementation
*******************************************************************************/

var addListItem = function( imgPath, itemNumber ) {
  var html = '<li><img src="' + imgPath + '" onclick="itemClicked( ' + itemNumber + ' )"/></li>';
  $( '#carousel' ).append( html );
}

var render = function() {
  $( '#carousel' ).carousel();
}