contract IssuranceContract {
	
	mapping(uint256 => string[]) issuranceArr;
	
	mapping(uint256 => string[]) paybackArr;
	
	function setIssurance(uint256 key,string value){
		issuranceArr[key].push(value);
	}
	
	function getIssurance(uint256 key,uint index) constant returns (string){
		return issuranceArr[key][index];
	}
	
	function getIssuranceLength(uint256 key) constant returns (uint) {
		return issuranceArr[key].length;
	}
	
	function setPayback(uint256 key,string value){
		paybackArr[key].push(value);
	}
	
	function getPayback(uint256 key,uint index) constant returns (string){
		return paybackArr[key][index];
	}
	
	function getPaybackLength(uint256 key) constant returns (uint) {
		return paybackArr[key].length;
	}
	
}
