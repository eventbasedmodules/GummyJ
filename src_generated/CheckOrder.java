package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.types.Construct;
import org.gummymodules.core.types.Destruct;
import org.gummymodules.core.types.AppearanceTerminated;
import org.gummymodules.core.types.DisappearanceTerminated;

public class CheckOrder extends org.gummymodules.core.metamodel.EmergentCompositeGummyModule {
	public volatile boolean opened = false;
	
	public CheckOrder(String name) throws org.gummymodules.core.helpers.GummyException 	{
		super(name, name);
		this.addComponent(new CheckOrder_EventMethod_check(this, "CheckOrder_EventMethod_check"), true, true, true);
	}
	
	private boolean getOpened() 	{
		return this.opened;
	}
	
	private void setOpened(boolean opened) 	{
		this.opened = opened;
	}
	
	private EventType create(EventType source) 	{
		OutofOrderEvent output = new OutofOrderEvent();
		output.set("fileID", source.get("fileID"));
		output.set("userID", source.get("publisher"));
		return output;
	}
	
	
	public class CheckOrder_EventMethod_check 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public CheckOrder_EventMethod_check(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequiredNested(CheckOrder.class, this.enclosing, CheckOrder_EventMethod_check_selector.class.getName(), "selector"));
			}
			;
			// program
			{
				this.addPrograms(new CheckOrder_EventMethod_check_implementation(this, "program"));
			}
			;
			// provided
			{
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvidedNested(CheckOrder.class, this.enclosing, OutofOrderEvent.class.getName(), "OutofOrderEvent"));
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("selector.output", "program"));
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("program", "OutofOrderEvent"));
			}
			;
			// misc
			{
				this.computeMetaData();
			}
			;
		}
		
	}
	
	
	public class CheckOrder_EventMethod_check_selector 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public CheckOrder_EventMethod_check_selector(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
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
				this.addPrograms(new CheckOrder_EventMethod_check_selector_implementation(this, "program"));
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
	
	
	public class CheckOrder_EventMethod_check_selector_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public CheckOrder_EventMethod_check_selector_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if ((false || (input instanceof FileEvents)))
			{
				this.publish(input);
			}
		}
		
	}
	
	
	public class CheckOrder_EventMethod_check_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public CheckOrder_EventMethod_check_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if ((false || (input instanceof OpenEvent)))
			{
				if ((! opened))
				{
					opened = true;
				}
				else
				{
					{
						org.gummymodules.core.types.EventType output_0012 = create(input);
						if ((false || (output_0012 instanceof OutofOrderEvent)))
						{
							this.publish(output_0012);
						}
						else
						{
							throw new org.gummymodules.core.helpers.GummyException("type of event to be published has not been declared in the primitive publisher");
						}
					}
				}
			}
			else
			{
				if (((false || (input instanceof ReadEvent)) || (input instanceof WriteEvent)))
				{
					if ((! opened))
					{
						{
							org.gummymodules.core.types.EventType output_0024 = create(input);
							if ((false || (output_0024 instanceof OutofOrderEvent)))
							{
								this.publish(output_0024);
							}
							else
							{
								throw new org.gummymodules.core.helpers.GummyException("type of event to be published has not been declared in the primitive publisher");
							}
						}
					}
				}
				else
				{
					if ((false || (input instanceof CloseEvent)))
					{
						if ((! opened))
						{
							{
								org.gummymodules.core.types.EventType output_0032 = create(input);
								if ((false || (output_0032 instanceof OutofOrderEvent)))
								{
									this.publish(output_0032);
								}
								else
								{
									throw new org.gummymodules.core.helpers.GummyException("type of event to be published has not been declared in the primitive publisher");
								}
							}
						}
						else
						{
							opened = false;
						}
					}
				}
			}
		}
		
	}
	
}

