<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>License</h2>
				<p>Open source software licensing is one the most crucial yet confusing aspects of evaluating open source software's fitness.   
				The desire to use open source is generally based on financial benefits. However, even though the software is "free" to use, 
				it is critical to select the right open source software solution for a given situation.  Several categories of licensing are listed below: </p>
				<p><b>BSD-style Permissive Licenses</b> -- BSD is very permissive license that allows users of the software the freedom to modify and redistribute it in any way.  The only restrictions enforced by the BSD license are that if a user redistributes the software, modified or unmodified, they must:
					<ol>
						<li>Include the original license with copyright notice</li>
						<li>Use the software "<i>As Is</i>" and not hold the author liable for any damages</li>
						<li>Not use the names of the authors in an advertising of derivative works </li>
					</ol>
				</p>
				<p><b>Weak copyleft licenses</b>, such as GNU's Lesser General Public License, also state that if the licensed 
				software is modified and redistributed then the derivative must be open sourced.  However weak copyleft licenses 
				generally permit the runtime linking of the open source software to other programs.  This allows LGPL-licensed 
				software to be embedded in a proprietary program that is redistributed.  This makes the LGPL license more appropriate 
				for software libraries that are embedded in other programs, and in fact the LGPL is sometimes called the 
				Library General Purpose License.
				<p><b>Strong copyleft licenses</b>, such as the GPL, state that if the software is modified and redistributed, 
				the derivative must also be released as open source.  In addition, if the software is linked at runtime to another program 
				and redistributed, that program must be open sourced as well.  This prevents GPL-licensed software from being 
				embedded in a proprietary program that is redistributed.
				</p>
				</p>
				</div>
		</div>
		<div class="licenseMetric">
			<form:form action="saveLicense.html" commandName="license" >
				<form:label path="licenseName">License name:</form:label>
				<form:input path="licenseName" />
				<br><br>
				Please check the box if this license is acceptable
				for your project: <form:checkbox path="acceptable"/>
				<br><br>
				<input name="surveyId" type="hidden" value="${survey.id}"/>
				<input type="submit" name="submit" value="Next Metric" />  	or  
				<input type="submit" name="submit" value="Go to Summary" />				
			</form:form>
		</div>
	</div>
	<div style="clear: both; height: 40px;">&nbsp;</div>	
</div>