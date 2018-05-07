package T03T04_Barracks;

import T03T04_Barracks.contracts.Repository;
import T03T04_Barracks.contracts.Runnable;
import T03T04_Barracks.contracts.UnitFactory;
import T03T04_Barracks.core.Engine;
import T03T04_Barracks.core.factories.UnitFactoryImpl;
import T03T04_Barracks.data.UnitRepository;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
