<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	
		<html>
			<head>
				<title>XSLT Demo</title>
			</head>
			<body>
				<h2>Contact Details</h2>
				<table border="1">
					<tr bgcolor="orange">
					    <th>First</th>
					    <th>Last</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
					</tr>
					<xsl:for-each select="contact/person">
						<tr>
							<td>
								<xsl:value-of select="firstname"></xsl:value-of>
							</td>
							<td>
								<xsl:value-of select="lastname"></xsl:value-of>
							</td>
							<td>
								<xsl:value-of select="name"></xsl:value-of>
							</td>
							<td>
								<xsl:value-of select="email"></xsl:value-of>
							</td>
							<td>
								<xsl:value-of select="phone"></xsl:value-of>
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
			
		</html>
	
	</xsl:template>
</xsl:stylesheet>