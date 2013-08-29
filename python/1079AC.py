import sys
def memorize(function):
  memo = {}
  def wrapper(*args):
    if args in memo:
      return memo[args]
    else:
      rv = function(*args)
      memo[args] = rv
      return rv
  return wrapper
  
@memorize
def getNumber(i):
	"""" Maximum """	
	if i==0:
		return 0
	elif i==1:
		return 1
	elif i%2==0:
		return getNumber(i/2)
	elif i%2==1:
		return (getNumber(i/2)+getNumber(i/2+1))	

def print_max_element(n):
	result=[]
	for i in range(0,n+1):
		result.append(getNumber(i))
	return max(result)
	
def main():	
	inputseq=[]	
	while True:
		line = int(sys.stdin.readline())
		if line==0:
			break
		else:
			inputseq.append(line)
	#calculate
	#print inputseq
	for i in inputseq:
		print 	print_max_element(i)
	
	
	
if __name__ == "__main__":
    main()
    
