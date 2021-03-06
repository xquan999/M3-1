package eco.data.m3.routing.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import eco.data.m3.net.core.MId;
import eco.data.m3.net.message.Message;

/**
 * A message sent to other nodes requesting the Closest nodes to a key sent in this message.
 * 
 * @author xquan
 *
 */
public class NodeLookupMessage extends Message{
	
	private MId lookupId;
	
	public NodeLookupMessage(MId origin, MId lookup) {
		super(origin);
		this.lookupId = lookup;
	}
	
	public NodeLookupMessage(DataInputStream in) throws IOException {
		super(in);
	}

	public MId getLookupId() {
		return lookupId;
	}

	@Override
	public byte getCode() {
		return MessageCode.NODE_LOOKUP;
	}

    @Override
    public final void fromStream(DataInputStream in) throws IOException
    {
    	super.fromStream(in);
        this.lookupId = new MId(in);
    }

    @Override
    public void toStream(DataOutputStream out) throws IOException
    {
    	super.toStream(out);
        this.lookupId.toStream(out);
    }
	
}
