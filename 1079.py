#1079.py
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

def main():
	n=10
	result=[]
	for i in range(0,n+1):
		result.append(getNumber(i))
	print result
	print max(result)


if __name__ == "__main__":
    main()
