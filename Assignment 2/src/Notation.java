import java.util.ArrayList;

/**
 * 
 * @author Santiago Sued
 *
 * Notation class that convers infix to postfix and evaluates both.
 */
public class Notation 
{
	
	/** Evaluates a postfix expression and computes its value.
	 * 
	 * @param postfixExpr Expression to convert to.
	 * @return Returns value of the postfix expression.
	 * @throws InvalidNotationFormatException
	 * @throws StackUnderflowException
	 * @throws StackOverflowException
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException, StackUnderflowException, StackOverflowException
	{
		char[] postfix = postfixExpr.toCharArray();
		MyStack<String> stack = new MyStack<String>(postfixExpr.length());
		String popped;
		for(int i=0;i<postfix.length;i++)
		{
			if(Character.isDigit(postfix[i]) || postfix[i]=='(')
			{
				stack.push(String.valueOf(postfix[i]));
			 System.out.println(postfix[i]);
				continue;
			}
			if(postfix[i]=='+')
				if(stack.size() < 2)
					throw new InvalidNotationFormatException();
				else
				{
					String toPushPlus = Double.toString((Double. parseDouble(stack.pop())  + Double. parseDouble(stack.pop())));
					System.out.println("Adding: " + toPushPlus);
					stack.push(toPushPlus);
					System.out.println("Stack is currently: " + stack.toString(", "));
					continue;
				}
			if(postfix[i]=='-')
				if(stack.size() < 2)
					throw new InvalidNotationFormatException();
				else
				{
					String toPushMinus = Double.toString((Double. parseDouble(stack.pop())  - Double. parseDouble(stack.pop())));
					//System.out.println("This should not be printing, error in -!");
					System.out.println("Subtracting: " + toPushMinus);
					stack.push(toPushMinus);
					System.out.println("Stack is currently: " + stack.toString(", "));
					continue;
				}
			if(postfix[i]=='*')
				if(stack.size() < 2)
					throw new InvalidNotationFormatException();
				else
				{
					String toPushTimes = Double.toString((Double. parseDouble(stack.pop())  * Double. parseDouble(stack.pop())));
					System.out.println("Multiplying: " + toPushTimes);
					stack.push(toPushTimes);
					System.out.println("Stack is currently: " + stack.toString(", "));
					continue;
				}
			if(postfix[i]=='/')
				if(stack.size() < 2)
					throw new InvalidNotationFormatException();
				else
				{
					String toPushDivide = Double.toString((Double. parseDouble(stack.pop())  / Double. parseDouble(stack.pop())));
					System.out.println("Dividing: " + toPushDivide);
					stack.push(toPushDivide);
					System.out.println("Stack is currently: " + stack.toString(", "));
					continue;
				}
		}
				
		if(stack.size() != 1)
			throw new InvalidNotationFormatException();
		else 
			popped = stack.pop();
			return Double.parseDouble(popped);
	}
	
	/** Converts a postfix expression into an equivalent infix form.
	 * 
	 * @param postfix Postfix expression to convert.
	 * @return Converted infix experession.
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException
	{
		char[] postfixChar = postfix.toCharArray();
		MyStack<String> stack = new MyStack<String>();
		try {
		for(int i=0;i<postfixChar.length;i++)
		{
			if(Character.isDigit(postfixChar[i]))
			{
				stack.push(String.valueOf(postfixChar[i]));
				continue;
			}
			
			if(postfixChar[i] =='+')
			{
				String second = stack.pop();
				String first = stack.pop();
				stack.push("("+ first + "+" + second + ")");
				continue;
			}
			
			if(postfixChar[i] =='-')
			{
				String second = stack.pop();
				String first = stack.pop();
				stack.push("("+ first + "-" + second + ")");
				continue;
			}
			
			if(postfixChar[i] =='*')
			{
				String second = stack.pop();
				String first = stack.pop();
				stack.push("("+ first + "*" + second + ")");
				continue;
			}
			
			if(postfixChar[i] =='/')
			{
				String second = stack.pop();
				String first = stack.pop();
				stack.push("("+ first + "/" + second + ")");
				continue;
			}
		}
		return stack.pop();
		}
		catch(Exception e) {
			throw new InvalidNotationFormatException();}
	}
	
	/** Converts an infix expression into an equivalent postfix form.
	 * 
	 * @param infix Infix string to convert.
	 * @return Converted postfix form.
	 * @throws InvalidNotationFormatException
	 * @throws QueueOverflowException
	 * @throws StackUnderflowException
	 * @throws StackOverflowException
	 */
public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException, QueueOverflowException, StackUnderflowException, StackOverflowException {
		
		MyStack<String> postfixStack = new MyStack<String>(infix.length());
		MyQueue<String> postfixQueue = new MyQueue<String>(infix.length());
		char[] infixArray = infix.toCharArray();
		
			for(int i=0;i<infixArray.length;i++) 
			{
				if(Character.isDigit(infixArray[i])) 
				{
					postfixQueue.enqueue(String.valueOf(infixArray[i]));
				}
				
				if(infixArray[i]=='(') 
				{
					postfixStack.push(String.valueOf(infixArray[i]));
				}
				
				if(infixArray[i]=='+') 
				{
					if(!postfixStack.isEmpty()) 
					{
						while(postfixStack.top().equals("+") || postfixStack.top().equals("-") || postfixStack.top().equals("*") || postfixStack.top().equals("/")) 
						{
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					postfixStack.push(String.valueOf(infixArray[i]));
				}
				
				if(infixArray[i]=='-') 
				{
					if(!postfixStack.isEmpty()) 
					{
						while(postfixStack.top().equals("+") || postfixStack.top().equals("-") || postfixStack.top().equals("*") || postfixStack.top().equals("/")) 
						{
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					postfixStack.push(String.valueOf(infixArray[i]));
				}
				
				if(infixArray[i]=='*') 
				{
					if(!postfixStack.isEmpty()) 
					{
						while(postfixStack.top().equals("*") || postfixStack.top().equals("/")) 
						{
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					postfixStack.push(String.valueOf(infixArray[i]));
				}
				
				if(infixArray[i]=='/') 
				{
					if(!postfixStack.isEmpty()) 
					{
						while(postfixStack.top().equals("*") || postfixStack.top().equals("/")) 
						{
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					postfixStack.push(String.valueOf(infixArray[i]));
				}
				
				if(infixArray[i]==')') 
				{
					while(!postfixStack.isEmpty() && !postfixStack.top().equals("(")) 
					{
						postfixQueue.enqueue(postfixStack.pop());
					}
					if(postfixStack.isEmpty() || !postfixStack.top().equals("(")) 
					{
						throw new InvalidNotationFormatException();
					}
					
					if(!postfixStack.isEmpty() && postfixStack.top().equals("("))
					{
						postfixStack.pop();
					}
				}
			}
			
			while(!postfixStack.isEmpty() && !postfixStack.top().equals("(")) 
			{
				postfixQueue.enqueue(postfixStack.pop());
			}
			
		return postfixQueue.toString();
	}
}
