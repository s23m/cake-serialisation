/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is S23M.
 *
 * The Initial Developer of the Original Code is
 * The S23M Foundation.
 * Portions created by the Initial Developer are
 * Copyright (C) 2012 The S23M Foundation.
 * All Rights Reserved.
 *
 * Contributor(s):
 * Andrew Shewring
 * ***** END LICENSE BLOCK ***** */
package org.s23m.cell.communication.xml;

// TODO integrate with multi-lingual support being built 
public interface XmlSchemaTerminology {
	boolean isMachineEncoding();
	
	String artifactSet();
	String codeName();
	String command();
	String container();
	String edge();
	String from();
	String identity();
	String identifier();
	String isAbstract();
	String isContainer();
	String isNavigable();
	String language();
	String maximumCardinality();
	String minimumCardinality();
	String model();
	String name();
	String parameter();
	String payload();
	String pluralCodeName();
	String pluralName();
	String query();
	String semanticDomain();
	String semanticIdentity();
	String structure();
	String superSetReference();
	String to();
	String uniqueRepresentationReference();
	String vertex();
	String visibility();
	
	/* Schema-only concepts */
	String category();
	String edgeEnd();
	String function();
	String graph();
	String identityReference();
	String uuid();
}