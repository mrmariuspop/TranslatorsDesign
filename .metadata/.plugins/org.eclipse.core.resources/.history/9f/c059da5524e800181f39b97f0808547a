<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
<xsl:template match="/Recipes">
	<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
		<fo:layout-master-set>
			<fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-left="2cm" margin-right="2cm" margin-bottom="2cm">
				<fo:region-body/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="A4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="12pt">
						<xsl:apply-templates/>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
	</fo:root>
</xsl:template>
<xsl:template match="Recipe">
Retete: 
<fo:block>
<fo:list-block>
	<xsl:for-each select=".">
		<fo:list-item>
			<fo:list-item-label>
				<fo:block>
					
				</fo:block>
			</fo:list-item-label>
			<fo:list-item-body provisional-label-separation="10pt" start-indent="25pt">
				<fo:block>
					<xsl:value-of select="Title"/>
				</fo:block>
			</fo:list-item-body>
		</fo:list-item>
	</xsl:for-each>
</fo:list-block>
</fo:block>	
		
	
</xsl:template>
</xsl:stylesheet>
