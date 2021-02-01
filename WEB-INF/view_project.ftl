<#include "header.ftl">
	<h1>Information</h1>
	<img="">
	<h2>${project.title}</h2>
	<h3>from <a href="view_profile?email=${project.creator}&amp;sessionEmail=${sessionEmail}">${creatorName}</a></h2>
	<p>${project.description}</p>
	<div>
		<label>Finance limit: ${project.fundingLimit}€</label><br>
		<label>Total donations:</label><label>${project.totalDonations}</label><br>
		<label>Status: ${project.status}</label><br>
		<label>Parent project: ${project.pre}</label><br>
	</div>
	<div>
		
		<a href="new_project_fund?id=${id}&amp;sessionEmail=${sessionEmail}">Donate</a>
		<a href="view_project?action=deleteProject&amp;id=${id}&amp;sessionEmail=${sessionEmail}">Delete</a>
	 	<a href="edit_project?id=${id}&amp;sessionEmail=${sessionEmail}">Edit project</a>
	</div>
	<div>
		<h2>List of donators</h2>
		<#list donators as d>
			<label>${d.name}: ${d.amount}€</label><br>
		</#list>
	</div>
	<div>
		<h2>List of comments</h2>
		<#list comments as c>
			<label>${c.userName}: ${c.text}</label><br>
		</#list>
		<a href="view_comment?&amp;id=${id}&amp;sessionEmail=${sessionEmail}">Comment</a>
	</div>
<#include "footer.ftl">