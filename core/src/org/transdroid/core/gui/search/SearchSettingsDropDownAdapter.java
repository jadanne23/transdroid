package org.transdroid.core.gui.search;

import java.util.List;

import org.transdroid.core.gui.lists.SimpleListItem;
import org.transdroid.core.gui.navigation.FilterListItemAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * List adapter that holds search settings, that is, web searches and in-app search sites, displayed as content to a
 * Spinner instead of a ListView.
 * @author Eric Kok
 */
public class SearchSettingsDropDownAdapter extends FilterListItemAdapter {

	private final Context context;

	public SearchSettingsDropDownAdapter(Context context, List<? extends SimpleListItem> items) {
		super(context, items);
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// This returns the item to show in the action bar spinner
		SearchSettingSelectionView filterItemView;
		if (convertView == null || !(convertView instanceof SearchSettingSelectionView)) {
			filterItemView = SearchSettingSelectionView_.build(context);
		} else {
			filterItemView = (SearchSettingSelectionView) convertView;
		}
		filterItemView.bind((SearchSetting) getItem(position));
		return filterItemView;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// This returns the item to show in the drop down list
		return super.getView(position, convertView, parent);
	}

}