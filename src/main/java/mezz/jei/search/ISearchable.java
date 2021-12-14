package mezz.jei.search;

import it.unimi.dsi.fastutil.ints.IntSet;
import mezz.jei.config.Config.SearchMode;

public interface ISearchable {
	IntSet search(String word);

	default SearchMode getMode() {
		return SearchMode.ENABLED;
	}
}
