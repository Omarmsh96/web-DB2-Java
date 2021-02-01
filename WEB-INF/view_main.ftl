<#include "header.ftl">
		
		<a href="view_profile?action=myProfile&amp;sessionEmail=${sessionEmail}">My Profile</a>
		<div>
			<span>
				<h2>Open projects</h2>
				<#list openProjects as op>
					<h5><a href="view_project?id=${op.projectID}&amp;sessionEmail=${sessionEmail}">${op.title}</a></h5>
					<label>From: <a href="view_profile?email=${op.creator}&amp;sessionEmail=${sessionEmail}">${op.name}</a></label><br>
					<label>Actual: ${op.totalDonations}<label>
				</#list>
			</span>
		</div>
		<div>
			<h2>Supported projects</h2>
			<#list closedProjects as cp>
					<h5><a href="view_project?id=${cp.projectID}&amp;sessionEmail=${sessionEmail}">${cp.title}</a></h5>
					<label>From: ${cp.creator}€</label><br>
					<label>Actual: ${cp.totalDonations}<label>
				</#list>
		</div>
		<div>
			<a href="new_project?sessionEmail=${sessionEmail}">New Project</a>
		</div>
<#include "footer.ftl">