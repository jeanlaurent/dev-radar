<%--
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
 --%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<h2>Workspace <c:out value="${workspace.name}" /></h2>
<table>
	<tr>
		<td>Id:</td>
		<td><c:out value="${workspace.id}" /></td>
	</tr>
	<tr>
		<td>POM url :</td>
		<td><a href='<c:out value="${workspace.pomUrl}"/>'><c:out
			value="${workspace.pomUrl}" /></a></td>
	</tr>
	<tr>
		<td>Name :</td>
		<td><c:out value="${workspace.name}" /></td>
	</tr>
	<tr>
		<td>Description :</td>
		<td><c:out value="${workspace.description}" /></td>
	</tr>
	<tr>
		<td>Issue management :</td>
		<td><a href='<c:out value="${workspace.issueManagement}"/>'><c:out
			value="${workspace.issueManagement}" /></a></td>
	</tr>
	<tr>
		<td>CI management :</td>
		<td><a href='<c:out value="${workspace.ciManagement}"/>'><c:out
			value="${workspace.ciManagement}" /></a></td>
	</tr>
	<tr>
		<td>Scm :</td>
		<td><c:out value="${workspace.scm}" /></td>
	</tr>
	<tr>
		<td><a class="submit"
			href="<spring:url value="/workspaces/${workspace.id}/edit.html" htmlEscape="true" />">Edit</a></td>
		<td><form:form method="delete">
			<p class="submit"><input type="submit" value="Delete Workspace" /></p>
		</form:form></td>
	</tr>
</table>

<h2>Event Sources</h2>
<table>
    <tr>
        <td><b>Description</b></td>
        <td><b>Poller</b></td>
        <td><b>URL</b></td>
        <td><b>Proxy</b></td>
    </tr>
    <c:forEach var="eventSource" items="${workspace.eventSources}">
        <tr>
            <td><c:out value="${eventSource.description}" /></td>
            <td><c:out value="${eventSource.pollerDescriptor.name}" /></td>
            <td><c:out value="${eventSource.url}" /></td>
            <td><c:out value="${eventSource.proxyUrl}" /></td>
        </tr>
    </c:forEach>
    <tr>
    <td><a class="submit"
            href="<spring:url value="/workspaces/${workspace.id}/eventSources/form.html" htmlEscape="true" />">Add Event Source</a></td>
    </tr>
</table>

<h2>Events</h2>
<table>
	<tr>
		<td><b>Type</b></td>
		<td><b>Message</b></td>
		<td><b>Date</b></td>
	</tr>
	<c:forEach var="event" items="${workspace.events}">
		<tr>
			<td><c:out value="${event.source.description}" /></td>
			<td><c:out value="${event.message}" /></td>
			<td><c:out value="${event.date}" /></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>