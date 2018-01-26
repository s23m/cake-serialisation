package org.s23m.cell.communication.json.test;

import java.util.ArrayList;
import java.util.List;

import org.s23m.cell.Set;
import org.s23m.cell.api.models.SemanticDomain;
import org.s23m.cell.communication.AgencyTestFoundationTestCase;
import org.s23m.cell.communication.SetMarshallingException;
import org.s23m.cell.communication.json.JsonSetMarshaller;
import org.s23m.cell.communication.xml.NamespaceConstants;
import org.s23m.cell.communication.xml.XmlSchemaTerminology;
import org.s23m.cell.communication.xml.model.dom.Namespace;
import org.s23m.cell.communication.xml.test.DefaultXmlSchemaTerminology;
import org.s23m.cell.core.Vertex;
import org.s23m.cell.platform.api.Instantiation;
import org.s23m.cell.platform.testfoundation.AgencyTestFoundation;

public class JsonSetMarshallerTest extends AgencyTestFoundationTestCase {

	private List<Set> exampleModels = new ArrayList<Set>();
	
	protected void doAdditionalSetup() {
		// only instances of Agents or any of their contained models ever need to be serialised 
		// ithanku is an example of an instance of an Agent. 
		exampleModels.add(AgencyTestFoundation.ithanku);
		exampleModels.add(AgencyTestFoundation.ernst);
	}
	
	public void testSerialise() throws SetMarshallingException {
		// should be able to convert the set of models and the set of semantic domains to the XML format
		
		Namespace namespace = NamespaceConstants.NS_S23M;
		XmlSchemaTerminology terminology = DefaultXmlSchemaTerminology.getInstance();
		JsonSetMarshaller setMarshaller = new JsonSetMarshaller(namespace, terminology);
		for (Set exampleModel : exampleModels) {
			
			String serialised = setMarshaller.serialise(exampleModel);
			assertNotNull(serialised);
			System.out.println("serialised: " + serialised);
		}	
		
		Set semanticDomain = Instantiation.toSemanticDomain(AgencyTestFoundation.ithanku);
		String serialisedSemanticDomain = setMarshaller.serialise(semanticDomain);
		System.out.println("serialisedSemanticDomain: " + serialisedSemanticDomain);
		
		Set containedVertices = semanticDomain.filterProperClass(Vertex.vertex);
		// try to list all semantic identities
		Set firstContainedSemanticDomain = containedVertices.extractFirst();
		final Set orderedSetOfSemanticIdentities = firstContainedSemanticDomain.filterPolymorphic(SemanticDomain.semanticIdentity);
		for (Set semanticIdentity: orderedSetOfSemanticIdentities) {
			System.out.println("semanticIdentity: " + semanticIdentity);
		}
		

	}
}
