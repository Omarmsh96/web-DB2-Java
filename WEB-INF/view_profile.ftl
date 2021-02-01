<#include "header.ftl">
	<div>
		<h3>profile of ${user.email}</h3>
		<label>User name: ${user.name}</label><br>
		<label>Number of created projects: ${createdCount}</label><br>
		<label>Number of supported projects: ${supportedCount}</lable><br>
	</div>
	<div>
		<span>
			<h2>Created projects</h2>
			<#list createdProjects as cp>
				<h5><a href="view_project?&amp;id=${cp.projectID}&amp;sessionEmail=${sessionEmail}">${cp.title}</a></h5>
				<label>Actual: ${cp.totalDonations}€</label><br>
				<label>Status: ${cp.status}<label>
			</#list>
		</span>
	</div>
	<div>
		<h2>Supported projects</h2>
		<#list supportedProjects as sp>
			<span>
				<h5><a href="view_project?&amp;id=${sp.projectID}&amp;sessionEmail=${sessionEmail}">${sp.title}</a></h5>
				<label>Limit: ${sp.fundingLimit}€</label><br>
				<label>Status: ${sp.status}</label><br>
				<label>Donated: ToBeDone</label>
			</span>
		</#list>
	</div>
<#include "footer.ftl">