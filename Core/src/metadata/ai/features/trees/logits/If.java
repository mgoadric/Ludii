package metadata.ai.features.trees.logits;

import annotations.Hide;
import annotations.Name;
import main.StringRoutines;

/**
 * Describes a decision node in a logit tree for features; it contains one
 * feature (the condition we check), and two branches; one for the case
 * where the condition is true, and one for the case where the condition is false.
 * 
 * @author Dennis Soemers
 */
@Hide
public class If extends LogitNode
{
	
	//-------------------------------------------------------------------------
	
	/** String description of the feature we want to evaluate as condition */
	protected final String feature;
	
	/** Node we navigate to when the condition is satisfied */
	protected final LogitNode thenNode;
	
	/** Node we navigate to when condition is not satisfied */
	protected final LogitNode elseNode;
	
	//-------------------------------------------------------------------------

	/**
	 * Defines the feature (condition), and the two branches.
	 * @param feature The feature to evaluate (the condition).
	 * @param then The branch to take if the feature is active.
	 * @param Else The branch to take if the feature is not active.
	 */
	public If
	(
				final String feature,
		@Name	final LogitNode then,
		@Name	final LogitNode Else
	)
	{
		this.feature = feature;
		this.thenNode = then;
		this.elseNode = Else;
	}
	
	//-------------------------------------------------------------------------
	
	@Override
	public String toString()
	{
		return toString(0);
	}
	
	@Override
	public String toString(final int indent)
	{
		final StringBuilder sb = new StringBuilder();
		final String outerIndentStr = StringRoutines.indent(4, indent);
		final String innerIndentStr = StringRoutines.indent(4, indent + 1);
		
		sb.append("(if " + StringRoutines.quote(feature) + "\n");
		sb.append(innerIndentStr + "then:" + thenNode.toString(indent + 1) + "\n");
		sb.append(innerIndentStr + "else:" + elseNode.toString(indent + 1) + "\n");
		sb.append(outerIndentStr + ")");
		
		return sb.toString();
	}
	
	//-------------------------------------------------------------------------
	
}
