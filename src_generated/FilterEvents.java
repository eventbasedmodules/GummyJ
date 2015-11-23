package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.types.Construct;
import org.gummymodules.core.types.Destruct;
import org.gummymodules.core.types.AppearanceTerminated;
import org.gummymodules.core.types.DisappearanceTerminated;

public class FilterEvents extends org.gummymodules.core.metamodel.EmergentCompositeGummyModule {
	public volatile int counter = 0;
	
	public FilterEvents(String name) throws org.gummymodules.core.helpers.GummyException 	{
		super(name, name);
		this.addComponent(new FilterEvents_EventMethod_filter(this, "FilterEvents_EventMethod_filter"), true, true, true);
	}
	
	private int getCounter() 	{
		return this.counter;
	}
	
	private void setCounter(int counter) 	{
		this.counter = counter;
	}
	
	
	public class FilterEvents_EventMethod_filter 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public FilterEvents_EventMethod_filter(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequiredNested(FilterEvents.class, this.enclosing, FilterEvents_EventMethod_filter_selector.class.getName(), "selector"));
			}
			;
			// program
			{
				this.addPrograms(new FilterEvents_EventMethod_filter_implementation(this, "program"));
			}
			;
			// provided
			{
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvidedNested(FilterEvents.class, this.enclosing, TimeoutEvent.class.getName(), "TimeoutEvent"));
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvidedNested(FilterEvents.class, this.enclosing, OutofOrderEvent.class.getName(), "OutofOrderEvent"));
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("selector.output", "program"));
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("program", "TimeoutEvent"));
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
	
	
	public class FilterEvents_EventMethod_filter_selector 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public FilterEvents_EventMethod_filter_selector(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
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
				this.addPrograms(new FilterEvents_EventMethod_filter_selector_implementation(this, "program"));
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
	
	
	public class FilterEvents_EventMethod_filter_selector_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public FilterEvents_EventMethod_filter_selector_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if (((false || (input instanceof TimeoutEvent)) || (input instanceof OutofOrderEvent)))
			{
				this.publish(input);
			}
		}
		
	}
	
	
	public class FilterEvents_EventMethod_filter_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public FilterEvents_EventMethod_filter_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if ((false || (input instanceof TimeoutEvent)))
			{
				counter = (counter + 1);
				if ((counter > 3))
				{
					{
						org.gummymodules.core.types.EventType output_008e = input;
						if (((false || (output_008e instanceof TimeoutEvent)) || (output_008e instanceof OutofOrderEvent)))
						{
							this.publish(output_008e);
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
				{
					org.gummymodules.core.types.EventType output_0093 = input;
					if (((false || (output_0093 instanceof TimeoutEvent)) || (output_0093 instanceof OutofOrderEvent)))
					{
						this.publish(output_0093);
					}
					else
					{
						throw new org.gummymodules.core.helpers.GummyException("type of event to be published has not been declared in the primitive publisher");
					}
				}
			}
		}
		
	}
	
}

