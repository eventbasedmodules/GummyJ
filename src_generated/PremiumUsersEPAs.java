package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.types.Construct;
import org.gummymodules.core.types.Destruct;
import org.gummymodules.core.types.AppearanceTerminated;
import org.gummymodules.core.types.DisappearanceTerminated;

public class PremiumUsersEPAs extends org.gummymodules.core.metamodel.EmergentCompositeGummyModule {
	private String userID;
	private String fileID;
	private boolean appearance_initialized = false;
	
	public PremiumUsersEPAs(String name, String userID, String fileID) throws org.gummymodules.core.helpers.GummyException 	{
		super(name, name);
		this.userID = userID;
		this.fileID = fileID;
		this.addComponent(new PremiumUsersEPAs_EventMethod_appearance(this, "PremiumUsersEPAs_EventMethod_appearance"), true, true, true);
		this.addComponent(new PremiumUsersEPAs_EventMethod_disappearance(this, "PremiumUsersEPAs_EventMethod_disappearance"), true, true, true);
		this.addComponent(new FilterUsers("component009e", userID, fileID), true, false, false);
		this.addComponent(new CheckOrder("component009f"), false, true, false);
		this.addComponent(new CheckTimeout("component00a0"), false, true, false);
		this.addComponent(new FilterEvents("component00a1"), false, false, true);
	}
	
	private void init_vars() 	{
		if ((! this.appearance_initialized))
		{
			{
			}
			this.appearance_initialized = true;
		}
	}
	
	
	public class PremiumUsersEPAs_EventMethod_appearance 	extends org.gummymodules.core.metamodel.AppearanceGummyModule 	{
		
		public PremiumUsersEPAs_EventMethod_appearance(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequiredNested(PremiumUsersEPAs.class, this.enclosing, PremiumUsersEPAs_EventMethod_appearance_selector.class.getName(), "selector"));
			}
			;
			// program
			{
				this.addPrograms(new PremiumUsersEPAs_EventMethod_appearance_implementation(this, "program"));
			}
			;
			// provided
			{
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvidedNested(PremiumUsersEPAs.class, this.enclosing, Construct.class.getName(), "Construct"));
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvidedNested(PremiumUsersEPAs.class, this.enclosing, AppearanceTerminated.class.getName(), "appearance_terminated"));
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("selector.output", "program"));
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("program", "Construct"));
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("program", "appearance_terminated"));
			}
			;
			// misc
			{
				this.computeMetaData();
			}
			;
		}
		
	}
	
	
	public class PremiumUsersEPAs_EventMethod_appearance_selector 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public PremiumUsersEPAs_EventMethod_appearance_selector(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
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
				this.addPrograms(new PremiumUsersEPAs_EventMethod_appearance_selector_implementation(this, "program"));
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
	
	
	public class PremiumUsersEPAs_EventMethod_appearance_selector_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public PremiumUsersEPAs_EventMethod_appearance_selector_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if ((false || (input instanceof BeginEvent)))
			{
				this.publish(input);
			}
		}
		
	}
	
	
	public class PremiumUsersEPAs_EventMethod_appearance_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public PremiumUsersEPAs_EventMethod_appearance_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			PremiumUsersEPAs.this.init_vars();
			{
				this.publish(new org.gummymodules.core.types.Construct());
			}
			if (PremiumUsersEPAs.this.active)
			{
				this.publish(new org.gummymodules.core.types.AppearanceTerminated());
			}
		}
		
	}
	
	
	public class PremiumUsersEPAs_EventMethod_disappearance 	extends org.gummymodules.core.metamodel.DisappearanceGummyModule 	{
		
		public PremiumUsersEPAs_EventMethod_disappearance(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			// init
			super(name, name);
			this.enclosing = enclosing;
			;
			// required
			{
				this.addRequiredInterface(org.gummymodules.core.helpers.Instantiator.instantiateRequiredNested(PremiumUsersEPAs.class, this.enclosing, PremiumUsersEPAs_EventMethod_disappearance_selector.class.getName(), "selector"));
			}
			;
			// program
			{
				this.addPrograms(new PremiumUsersEPAs_EventMethod_disappearance_implementation(this, "program"));
			}
			;
			// provided
			{
				this.addProvidedInterface(org.gummymodules.core.helpers.Instantiator.instantiateProvidedNested(PremiumUsersEPAs.class, this.enclosing, Destruct.class.getName(), "Destruct"));
			}
			;
			// bindings
			{
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("selector.output", "program"));
				this.binder.getBindings().add(new org.gummymodules.core.metamodel.BindingInfo("program", "Destruct"));
			}
			;
			// misc
			{
				this.computeMetaData();
			}
			;
		}
		
	}
	
	
	public class PremiumUsersEPAs_EventMethod_disappearance_selector 	extends org.gummymodules.core.metamodel.PrimitiveGummyModule 	{
		
		public PremiumUsersEPAs_EventMethod_disappearance_selector(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
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
				this.addPrograms(new PremiumUsersEPAs_EventMethod_disappearance_selector_implementation(this, "program"));
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
	
	
	public class PremiumUsersEPAs_EventMethod_disappearance_selector_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public PremiumUsersEPAs_EventMethod_disappearance_selector_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			if ((false || (input instanceof EndEvent)))
			{
				this.publish(input);
			}
		}
		
	}
	
	
	public class PremiumUsersEPAs_EventMethod_disappearance_implementation 	extends org.gummymodules.core.metamodel.AtomicProgram 	{
		
		public PremiumUsersEPAs_EventMethod_disappearance_implementation(org.gummymodules.core.metamodel.GummyModule enclosing, String name) throws org.gummymodules.core.helpers.GummyException 		{
			super(name);
			this.enclosing = enclosing;
		}
		
		public void execute(org.gummymodules.core.types.EventType input) throws org.gummymodules.core.helpers.GummyException 		{
			{
				{
					this.publish(new org.gummymodules.core.types.Destruct());
					PremiumUsersEPAs.this.appearance_initialized = false;
				}
			}
			if (PremiumUsersEPAs.this.active)
			{
				this.publish(new org.gummymodules.core.types.DisappearanceTerminated());
			}
		}
		
	}
	
}

