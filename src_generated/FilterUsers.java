package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.types.Construct;
import org.gummymodules.core.types.Destruct;
import org.gummymodules.core.types.AppearanceTerminated;
import org.gummymodules.core.types.DisappearanceTerminated;

public class FilterUsers extends org.gummymodules.core.metamodel.EmergentCompositeGummyModule {
	private String userID;
	private String fileID;
	
	public FilterUsers(String name, String userID, String fileID) throws org.gummymodules.core.helpers.GummyException 	{
		super(name, name);
		this.userID = userID;
		this.fileID = fileID;
		this.addComponent(new FilterUsers_EventMethod_filter(this, "FilterUsers_EventMethod_filter"), true, true, true);
	}
	
	
	public class FilterUsers_EventMethod_filter 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public FilterUsers_EventMethod_filter(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequiredNested(FilterUsers.class, this.enclosing, FilterUsers_EventMethod_filter_selector.class.getName(), "selector"));
			}
			;
			// program
			{
				this.addPrograms(new FilterUsers_EventMethod_filter_implementation(this, "program"));
			}
			;
			// provided
			{
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvidedNested(FilterUsers.class, this.enclosing, FileEvents.class.getName(), "FileEvents"));
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("selector.output", "program"));
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("program", "FileEvents"));
			}
			;
			// misc
			{
				this.computeMetaData();
			}
			;
		}
		
	}
	
	
	public class FilterUsers_EventMethod_filter_selector 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public FilterUsers_EventMethod_filter_selector(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequired(org.gummymodules.core.types.EventType.class.getName(), "input"));
			}
			;
			// program
			{
				this.addPrograms(new FilterUsers_EventMethod_filter_selector_implementation(this, "program"));
			}
			;
			// provided
			{
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvided(org.gummymodules.core.types.EventType.class.getName(), "output"));
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("input", "program"));
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("program", "output"));
			}
			;
			// misc
			{
				this.computeMetaData();
			}
			;
		}
		
	}
	
	
	public class FilterUsers_EventMethod_filter_selector_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public FilterUsers_EventMethod_filter_selector_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if (((((false || (input instanceof FileEvents)) && input.get("publisher").equals(userID)) && input.get("userrole").equals("premium")) && input.get("fileID").equals(fileID)))
			{
				this.publish(input);
			}
		}
		
	}
	
	
	public class FilterUsers_EventMethod_filter_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public FilterUsers_EventMethod_filter_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			{
				org.gummymodules.core.types.EventType output_0001 = input;
				if ((false || (output_0001 instanceof FileEvents)))
				{
					this.publish(output_0001);
				}
				else
				{
					throw new org.gummymodules.core.helpers.GummyException("type of event to be published has not been declared in the primitive publisher");
				}
			}
		}
		
	}
	
}

