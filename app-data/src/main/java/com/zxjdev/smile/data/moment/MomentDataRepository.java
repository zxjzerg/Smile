package com.zxjdev.smile.data.moment;

import com.zxjdev.smile.data.base.BaseDataRepository;
import com.zxjdev.smile.data.moment.datasource.MomentCloudDataSource;
import com.zxjdev.smile.data.moment.entity.MomentMapper;
import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.domain.moment.MomentRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MomentDataRepository extends BaseDataRepository implements MomentRepository {

  private MomentCloudDataSource momentCloudDataSource;
  private MomentMapper momentMapper;

  @Inject
  public MomentDataRepository(MomentCloudDataSource momentCloudDataSource, MomentMapper momentMapper) {
    this.momentCloudDataSource = momentCloudDataSource;
    this.momentMapper = momentMapper;
  }

  @Override
  public Observable<Void> addMoment(String content) {
    return momentCloudDataSource.addMoment(content).compose(applyDefaultSchedulerStrategy());
  }

  @Override
  public Observable<List<Moment>> queryMomentList() {
    return momentCloudDataSource.getMomentList()
      .map(momentEntities -> momentMapper.transform(momentEntities))
      .compose(applyDefaultSchedulerStrategy());
  }

  @Override
  public Observable<Moment> queryMoment(String momentId) {
    return null;
  }
}
