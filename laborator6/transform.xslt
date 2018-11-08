<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/Recipes">
		<!-- template number 1 -->
		<html>
		<head>
		<title>blblabla</title>
		</head>
		<body>
		<h1>Recipe</h1>
		<table border="1">
			<tr>
				<th scope="col"><b>Title</b></th>
				<th scope="col"><b>Ingredients</b></th>
				<th scope="col"><b>Preparation</b></th>
				<th scope="col"><b>Comment</b></th>
				<th scope="col" colspan="5"><b>Nutrients</b></th>
			</tr>
		<xsl:apply-templates/>
		</table>
		</body>
		</html>
	</xsl:template>
	<xsl:template match="Recipes/Recipe">
		<!-- template number 2 -->
		
		<tr>
		<th scope="row"><xsl:value-of select="Title"/></th>
		<td><xsl:apply-templates select="Ingredients"/></td>
		<td><xsl:apply-templates select="Preparation"/></td>
		<td><xsl:value-of select="Comment"/></td>
		<td><xsl:apply-templates select="Nutrients"/></td>
		</tr>
		
	</xsl:template>
	<xsl:template match="Ingredients">
		<!-- template number 3 -->
		
		<xsl:for-each select="Ingredient">
		
		<xsl:value-of select="@name"/>
		<xsl:value-of select="@qty"/>
		<xsl:value-of select="@unit"/>
		
	</xsl:for-each>
	</xsl:template>
	<xsl:template match="Preparation">
		<!-- template number 4 -->
		<xsl:for-each select="Step">
		<xsl:value-of select="."/>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="Nutrients">
		<!-- template number 5 -->
		
		<xsl:value-of select="@proteins"/>
		<xsl:value-of select="@carbohid"/>
		<xsl:value-of select="@fat"/>
		<xsl:value-of select="@vitamins"/>
		<xsl:value-of select="@calories"/>
	
	</xsl:template>
</xsl:stylesheet>