package vswe.stevesvehicles.old.Buttons;
import vswe.stevesvehicles.module.cart.attachment.ModuleComputer;
import vswe.stevesvehicles.old.Computer.ComputerTask;

public class ButtonVarUseSecondVar extends ButtonVarUseVar {
	

    public ButtonVarUseSecondVar(ModuleComputer module, LOCATION loc, boolean use)
    {
		super(module, loc, use);	
	}
	
	@Override
	protected boolean getUseVar(ComputerTask task) {
		return task.getVarUseSecondVar();
	}
	
	@Override
	protected void setUseVar(ComputerTask task, boolean val) {
		task.setVarUseSecondVar(val);
	}
	
	@Override
	protected String getName() {
		return "second";
	}
	
	@Override
	protected boolean isSecondValue() {
		return true;
	}
}