package vswe.stevesvehicles.old.Modules.Engines;
import vswe.stevesvehicles.vehicle.entity.EntityModularCart;

public class ModuleThermalStandard extends ModuleThermalBase {
	public ModuleThermalStandard(EntityModularCart cart) {
		super(cart);
	}
	
	@Override
	protected int getEfficiency() {
		return 25;
	}
	
	@Override
	protected int getCoolantEfficiency() {
		return 0;
	}
	
}