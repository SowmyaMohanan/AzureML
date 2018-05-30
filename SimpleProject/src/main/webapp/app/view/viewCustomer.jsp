
<div>
<table id="studDetails">
			<thead>
				<tr>
					<th>Closure Status</th>
					<th>Location</th>
					<th>Email Available</th>
					<th>Phone Available</th>
					<th>Offer Rejection Reason Available</th>
					<th>Existing Customer</th>
					<th>Call Status Abandoned</th>
					<th>Call Status Depleted</th>
					<th>Call Status Expired</th>
					<th>Call Status New</th>
					<th>Call Status Redial Automatic</th>
					<th>Call Status Redial Manual Common</th>
					<th>Call Status Redial Manual Private</th>
					<th>Call Status User Processed</th>
					<th>Call Result Data Error</th>
					<th>Call Result Offers Accepted</th>
					<th>Call Result Offers Rejected</th>
					<th>Call Result Offers Submitted</th>
					<th>Call Result Unknown</th>
					<th>Call Count</th>
					<th>Offer Accepted</th>
					<th>Scored Labels</th>
					<th>Scored Probabilities</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="cust in view.customers">
					<td>{{cust.closureStatus}}</td>
					<td>{{cust.location}}</td>					
					<td>{{cust.emailAvailable}}</td>
					<td>{{cust.phoneAvailable}}</td>
					<td>{{cust.offerRejectionReasonAvailable}}</td>
					<td>{{cust.existingCustomer}}</td>
					<td>{{cust.callStatusAbandoned}}</td>
					<td>{{cust.callStatusDepleted}}</td>					
					<td>{{cust.callStatusExpired}}</td>
					<td>{{cust.callStatusNew}}</td>
					<td>{{cust.callStatusRedialAutomatic}}</td>
					<td>{{cust.callStatusRedialManualCommon}}</td>
					<td>{{cust.callStatusRedialManualPrivate}}</td>
					<td>{{cust.callStatusUserProcessed}}</td>					
					<td>{{cust.callResultDataError}}</td>
					<td>{{cust.callResultOffersAccepted}}</td>
					<td>{{cust.callResultOffersRejected}}</td>
					<td>{{cust.callResultOffersSubmitted}}</td>
					<td>{{cust.callResultUnknown}}</td>					
					<td>{{cust.callCount}}</td>
					<td>{{cust.offerAccepted}}</td>
					<td>{{cust.scoredLabels}}</td>
					<td>{{cust.scoredProbabilities}}</td>
				</tr>
			</tbody>
		</table>

</div>