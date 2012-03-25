<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Pedigree</h2>				
					The software pedigree criterion is determined by evaluating the authors, 
					patrons, and lineage of the project.  Organization and individuals who have 
					produced quality software in the past are more likely to produce quality software now.  
					Additionally software derived from other software that is known to be of high quality is 
					likely to benefit from that solid foundation.  Several items need to be considered when
					evaluating the pedigree of a piece of software.
					<ul>
						<li>Is the author of this software is known to produce high quality software?</li>
						<li>Is the group sponsoring or funding this software is known to produce high quality software?</li>
						<li>Is this software is derived from or makes heavy use of another piece of software that is known to be of high quality?</li>
					</ul> 	
				</div>
				<div id="authorDescription" style="display:none;">The Author score determines whether the author of this software is known to produce high quality software</div>
				<div id="groupSponsorDescription" style="display:none;">The Group Sponsor score is used to evaluate whether the group sponsoring or funding this software is known to produce high quality software.</div>
				<div id="derivedDescription" style="display:none;">The Derived score indicates whether this software is derived from or makes heavy use of another piece of software that is known to be of high quality.</div>
				<div class="surveySliders">
					<form:form action="savePedigree.html" commandName="pedigree" >
						<orca:targetSlider name="author" title="Author" value="${pedigree.author}"/>				
						<orca:targetSlider name="groupSponsor" title="Group Sponsor" value="${pedigree.groupSponsor}"/>				
						<orca:targetSlider name="derived" title="Derived" value="${pedigree.derived}"/>				
						<br><br>
						<input name="surveyId" type="hidden" value="${survey.id}"/>
						<input type="submit" name="submit" value="Next Metric" />  	or  
						<input type="submit" name="submit" value="Go to Summary" />				
					</form:form>
				</div>
		</div>
	</div>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>