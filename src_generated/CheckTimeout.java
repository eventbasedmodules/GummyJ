package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.types.Construct;
import org.gummymodules.core.types.Destruct;
import org.gummymodules.core.types.AppearanceTerminated;
import org.gummymodules.core.types.DisappearanceTerminated;

public class CheckTimeout extends org.gummymodules.core.metamodel.EmergentCompositeGummyModule {
	public volatile boolean opened = false;
	public volatile long last;
	public volatile long timer;
	public volatile int ttl = 2000;
	
	public CheckTimeout(String name) throws org.gummymodules.core.helpers.GummyException 	{
		super(name, name);
		this.addComponent(new CheckTimeout_EventMethod_open(this, "CheckTimeout_EventMethod_open"), true, true, false);
		this.addComponent(new CheckTimeout_EventMethod_readwrite(this, "CheckTimeout_EventMethod_readwrite"), true, true, true);
		this.addComponent(new CheckTimeout_EventMethod_close(this, "CheckTimeout_EventMethod_close"), true, true, false);
	}
	
	private boolean getOpened() 	{
		return this.opened;
	}
	
	private void setOpened(boolean opened) 	{
		this.opened = opened;
	}
	
	private long getLast() 	{
		return this.last;
	}
	
	private void setLast(long last) 	{
		this.last = last;
	}
	
	private long getTimer() 	{
		return this.timer;
	}
	
	private void setTimer(long timer) 	{
		this.timer = timer;
	}
	
	private int getTtl() 	{
		return this.ttl;
	}
	
	private void setTtl(int ttl) 	{
		this.ttl = ttl;
	}
	
	private long getCurrent() 	{
		return System.currentTimeMillis();
	}
	
	private long init() 	{
		last = getCurrent();
		return 0;
	}
	
	private long update() 	{
		return ((getCurrent() - last));
	}
	
	private long reset() 	{
		last = getCurrent();
		return 0;
	}
	
	
	public class CheckTimeout_EventMethod_open 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public CheckTimeout_EventMethod_open(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequiredNested(CheckTimeout.class, this.enclosing, CheckTimeout_EventMethod_open_selector.class.getName(), "selector"));
			}
			;
			// program
			{
				this.addPrograms(new CheckTimeout_EventMethod_open_implementation(this, "program"));
			}
			;
			// provided
			{
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("selector.output", "program"));
			}
			;
			// misc
			{
				this.computeMetaData();
			}
			;
		}
		
	}
	
	
	public class CheckTimeout_EventMethod_open_selector 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public CheckTimeout_EventMethod_open_selector(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
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
				this.addPrograms(new CheckTimeout_EventMethod_open_selector_implementation(this, "program"));
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
	
	
	public class CheckTimeout_EventMethod_open_selector_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public CheckTimeout_EventMethod_open_selector_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if ((false || (input instanceof OpenEvent)))
			{
				this.publish(input);
			}
		}
		
	}
	
	
	public class CheckTimeout_EventMethod_open_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public CheckTimeout_EventMethod_open_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if ((! opened))
			{
				opened = true;
				timer = init();
			}
		}
		
	}
	
	
	public class CheckTimeout_EventMethod_readwrite 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public CheckTimeout_EventMethod_readwrite(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequiredNested(CheckTimeout.class, this.enclosing, CheckTimeout_EventMethod_readwrite_selector.class.getName(), "selector"));
			}
			;
			// program
			{
				this.addPrograms(new CheckTimeout_EventMethod_readwrite_implementation(this, "program"));
			}
			;
			// provided
			{
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvidedNested(CheckTimeout.class, this.enclosing, TimeoutEvent.class.getName(), "TimeoutEvent"));
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("selector.output", "program"));
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("program", "TimeoutEvent"));
			}
			;
			// misc
			{
				this.computeMetaData();
			}
			;
		}
		
	}
	
	
	public class CheckTimeout_EventMethod_readwrite_selector 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public CheckTimeout_EventMethod_readwrite_selector(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
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
				this.addPrograms(new CheckTimeout_EventMethod_readwrite_selector_implementation(this, "program"));
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
	
	
	public class CheckTimeout_EventMethod_readwrite_selector_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public CheckTimeout_EventMethod_readwrite_selector_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if (((false || (input instanceof ReadEvent)) || (input instanceof WriteEvent)))
			{
				this.publish(input);
			}
		}
		
	}
	
	
	public class CheckTimeout_EventMethod_readwrite_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public CheckTimeout_EventMethod_readwrite_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			timer = update();
			if ((timer >= ttl))
			{
				TimeoutEvent output = new TimeoutEvent();
				output.set("fileID", input.get("fileID"));
				output.set("userID", input.get("publisher"));
				output.set("opentime", timer);
				{
					org.gummymodules.core.types.EventType output_006c = output;
					if ((false || (output_006c instanceof TimeoutEvent)))
					{
						this.publish(output_006c);
					}
					else
					{
						throw new org.gummymodules.core.helpers.GummyException("type of event to be published has not been declared in the primitive publisher");
					}
				}
			}
			else
			{
				timer = reset();
			}
		}
		
	}
	
	
	public class CheckTimeout_EventMethod_close 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public CheckTimeout_EventMethod_close(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequiredNested(CheckTimeout.class, this.enclosing, CheckTimeout_EventMethod_close_selector.class.getName(), "selector"));
			}
			;
			// program
			{
				this.addPrograms(new CheckTimeout_EventMethod_close_implementation(this, "program"));
			}
			;
			// provided
			{
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("selector.output", "program"));
			}
			;
			// misc
			{
				this.computeMetaData();
			}
			;
		}
		
	}
	
	
	public class CheckTimeout_EventMethod_close_selector 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public CheckTimeout_EventMethod_close_selector(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
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
				this.addPrograms(new CheckTimeout_EventMethod_close_selector_implementation(this, "program"));
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
	
	
	public class CheckTimeout_EventMethod_close_selector_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public CheckTimeout_EventMethod_close_selector_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if ((false || (input instanceof CloseEvent)))
			{
				this.publish(input);
			}
		}
		
	}
	
	
	public class CheckTimeout_EventMethod_close_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public CheckTimeout_EventMethod_close_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			timer = reset();
			opened = false;
		}
		
	}
	
}

