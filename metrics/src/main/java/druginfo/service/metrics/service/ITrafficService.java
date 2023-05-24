package druginfo.service.metrics.service;

import druginfo.service.metrics.models.AddProductModel;
import druginfo.service.metrics.models.SearchObject;

public interface ITrafficService {

    String addSearchObject(SearchObject searchObject);
}
