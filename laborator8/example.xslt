<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="Recipes">
	<xsl:apply-templates/>
</xsl:template>
<xsl:template match="Recipe">
Retete:
	<xsl:for-each select=".">
		<xsl:value-of select="Title"/>
	</xsl:for-each>
</xsl:template>
<xsl:apply-templates select="/"/>
<!-- goes further and build the list of templates adjacent to the root node.
	When we define a template we attach to it an attribute "match" the value of this attribute is a pattern
	What is a pattern? 
	A succesion of XPath expressions restrictioned separated with "|" between them, so there can be more
	XPath Expressions
	We can not use other axis than child and attribute
	
	So for the first step the one who contains the execution of apply templates select / we need 5 sub-steps
	1. build of subset formed from root with dimension 1
	2. build the list of templates from stylesheet
	3.4.5.processors starts to iterate on node set transforming consequently every node from node-set to current-node
	and for each current node it search in the list of templates a templates that perfectly mathches the node and if it finfs
	it it instantiates it and executes it otherwise it executes a predefined template (built in)
	C: For root node and element node the rpedefined template leads to the aprsing of all the child element -->
</xsl:stylesheet>