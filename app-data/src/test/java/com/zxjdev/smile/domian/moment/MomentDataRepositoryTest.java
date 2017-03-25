package com.zxjdev.smile.domian.moment;

import com.zxjdev.smile.data.moment.MomentDataRepository;
import com.zxjdev.smile.data.moment.MomentEntity;
import com.zxjdev.smile.data.moment.MomentMapper;
import com.zxjdev.smile.data.moment.datasource.MomentCloudDataSource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import rx.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MomentDataRepositoryTest {

  private MomentDataRepository momentDataRepository;
  @Mock MomentCloudDataSource momentCloudDataSource;
  @Mock MomentMapper momentMapper;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    momentDataRepository = new MomentDataRepository(momentCloudDataSource, momentMapper);
  }

  @Test
  public void testAddMoment() {
    String content = "123";
    momentDataRepository.addMoment(content);

    verify(momentCloudDataSource).addMoment(content);
  }

  @Test
  public void queryMomentList() {
    List<MomentEntity> momentList = mock(List.class);
    given(momentCloudDataSource.getMomentList()).willReturn(Observable.just(momentList));
    momentDataRepository.queryMomentList();

    verify(momentCloudDataSource).getMomentList();
  }

  @Test
  public void testQueryMoment() {
    String momentId = "123";
    momentDataRepository.queryMoment(momentId);

    verify(momentCloudDataSource.addMoment(momentId));
  }
}
