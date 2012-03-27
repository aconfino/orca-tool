<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Market Penetration</h2>
					It is important to include market leaders in a software evaluation.  
					Determining a market leader of open source software is a subjective, however there
					are several sources that can assist in determining market penetration
					<ol>
						<li>Number of reviews in trade magazines, websites, and blogs.  Sites such as Ohloh (<a href="http://www.ohloh.net">http://www.ohloh.net</a>) provide community reviews.</li>
						<li>Google Trends (<a href="http://trends.google.com">http://trends.google.com</a>) can be used to gauge popularity of the project's website</li>
						<li>For Linux-based software, inclusion in highly regarded Linux distributions such as <a href="http://www.redhat.com/">Red Hat</a> can be a sign of market penetration.</li>
					</ol>
				</div>
				<div id="marketPenetrationScoreDescription" style="display:none;">Score this software based on if it has wide market penetration.</div>
				<div class="surveySliders">
					<form:form action="saveMarketPenetration.html" commandName="marketPenetration" >
						<orca:targetSlider name="marketPenetrationScore" title="Market Penetration" value="${marketPenetration.marketPenetrationScore}"/>				
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