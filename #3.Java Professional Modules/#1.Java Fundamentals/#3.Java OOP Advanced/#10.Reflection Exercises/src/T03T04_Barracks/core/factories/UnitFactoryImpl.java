package T03T04_Barracks.core.factories;

import T03T04_Barracks.contracts.Unit;
import T03T04_Barracks.contracts.UnitFactory;
import T03T04_Barracks.data.UnitRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"T03T04_Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<?> unitClass= Class.forName(UNITS_PACKAGE_NAME+unitType);
		Constructor<?> constructor=unitClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		Unit unit= (Unit) constructor.newInstance();
		return unit;
	}
}
