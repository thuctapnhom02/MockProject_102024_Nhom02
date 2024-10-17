import React from "react";

const Services = () => {
  return (
    <div className="my-12">
      <h1 className="text-center font-bold text-3xl">MANAGERMENT SERVICES</h1>
      <div className="flex gap-14 mt-[52px] ml-16">
        <div className="w-1/2">
          <h2 className="font-bold text-2xl mb-10">RENT INVOICING</h2>
          <p className="font-normal text-2xl text-black/70">
            In order to help your tenants stay on top of rent payments, we send out monthly invoices (including a
            detailed breakdown of charges to their account) to remind them to payment is coming due.
          </p>
        </div>
        <div className="w-1/2">
          <h2 className="font-bold text-2xl mb-10">REPAIR & MAINTENANCE</h2>
          <p className="font-normal text-2xl text-black/70">
            Outside of responsiveness and organization, we thoroughly screen all of the vendors we work with to ensure
            your property is getting the best possible repair and/or maintenance work for the best possible price.
          </p>
        </div>
      </div>
      <div className="flex gap-14 mt-[52px] ml-16">
        <div>
          <h2 className="font-bold text-2xl mb-10">FINANCIAL REPORTING</h2>
          <p className="font-normal text-2xl text-black/70">
            Running a property is no different than running a business. We provide monthly, quarterly, and annual
            financial reports. Also, with our on-demand system, our clients can access financial reports in a moment’s
            notice.
          </p>
        </div>
        <div>
          <h2 className="font-bold text-2xl mb-10">APARTMENT TURNOVER SERVICES</h2>
          <p className="font-normal text-2xl text-black/70">
            After a tenant notifies us of their intent to move, we reply by scheduling a pre-move out inspection and we
            send them a Move Out Letter, which states the expectations regarding the condition of the property.
          </p>
        </div>
      </div>
    </div>
  );
};

export default Services;
