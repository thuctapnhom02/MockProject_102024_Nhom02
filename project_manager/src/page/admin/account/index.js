import { useState, useEffect } from "react";

import SearchBar from "../../../component/SearchBar/SearchBar";
import Filter from "../../../component/Filter/Filter";
import AccountTable from "../../../component/TableCustom/AccountTable";
import Modal from "../../../component/Modal/AccountModal";
import Button from "../../../component/Button";
import useDebounce from "../../../hooks/useDebound";

import { fetchStaffs } from "../../../api/staffApi";
import "./style.scss";

const Account = () => {
  const [accounts, setAccounts] = useState([]);
  const [filteredAccounts, setFilteredAccounts] = useState([]);
  const [search, setSearch] = useState("");
  const [accountTypeFilter, setAccountTypeFilter] = useState("");
  const [statusFilter, setStatusFilter] = useState("");
  const [selectedAccount, setSelectedAccount] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedAccounts, setSelectedAccounts] = useState([]);

  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);
  const pageSize = 9;

  // Sử dụng hook useDebounce
  const debouncedSearch = useDebounce(search, 300); // Delay 300ms

  // Fetch staff accounts based on current filters and search
  const fetchStaff = async () => {
    try {
      const data = await fetchStaffs(
        debouncedSearch, // Sử dụng giá trị debounced
        accountTypeFilter,
        statusFilter,
        currentPage,
        pageSize
      );
      setAccounts(data.result);
      setFilteredAccounts(data.result);

      const calculatedTotalPages = Math.ceil(data.totalItem / pageSize);
      setTotalPages(calculatedTotalPages);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  // Call fetchStaff whenever currentPage, debouncedSearch, accountTypeFilter, or statusFilter changes
  useEffect(() => {
    fetchStaff();
  }, [currentPage, debouncedSearch, accountTypeFilter, statusFilter]);

  const handlePageChange = (newPage) => {
    setCurrentPage(newPage);
  };

  // Filter accounts based on search and filters applied
  useEffect(() => {
    const filtered = accounts.filter(
      (acc) =>
        acc.phone.includes(debouncedSearch) &&
        (accountTypeFilter ? acc.role.nameRole === accountTypeFilter : true) &&
        (statusFilter ? acc.status === statusFilter : true)
    );
    setFilteredAccounts(filtered);
  }, [debouncedSearch, accountTypeFilter, statusFilter, accounts]);

  const handleEditAccount = (account) => {
    setSelectedAccount(account);
    setIsModalOpen(true);
  };

  const handleModalClose = () => {
    setIsModalOpen(false);
    setSelectedAccount(null);
  };

  const handleSave = (updatedAccount) => {
    if (selectedAccount) {
      const updatedAccounts = accounts.map((acc) =>
        acc.id === selectedAccount.id
          ? {
              ...selectedAccount,
              ...updatedAccount,
            }
          : acc
      );

      setAccounts(updatedAccounts);
      setFilteredAccounts(updatedAccounts);
    } else {
      const newAccount = {
        ...updatedAccount,
        id: `TK00${accounts.length + 1}`,
      };

      const updatedAccounts = [...accounts, newAccount];
      setAccounts(updatedAccounts);
      setFilteredAccounts(updatedAccounts);
    }
    setIsModalOpen(false);
  };

  const handleSelectAccount = (accountId) => {
    setSelectedAccounts((prevSelected) =>
      prevSelected.includes(accountId)
        ? prevSelected.filter((id) => id !== accountId)
        : [...prevSelected, accountId]
    );
  };

  const handleSelectAll = () => {
    if (selectedAccounts.length === filteredAccounts.length) {
      setSelectedAccounts([]);
    } else {
      setSelectedAccounts(filteredAccounts.map((acc) => acc.id));
    }
  };

  const handleDelete = () => {
    const remainingAccounts = accounts.filter(
      (account) => !selectedAccounts.includes(account.id)
    );
    setAccounts(remainingAccounts);
    setFilteredAccounts(remainingAccounts);
    setSelectedAccounts([]);
  };

  return (
    <div className="account-manager">
      <h1 className="account-manager-title">Account Management</h1>

      <div className="account-manager-filter">
        <SearchBar onSearch={setSearch} />
        <Filter
          label="Account Type"
          options={[
            "Admin",
            "Staff Repair",
            "Staff Maintenance",
            "Staff Complaint",
            "Staff Request",
            "Staff Income",
            "Staff Outcome",
          ]}
          onFilter={setAccountTypeFilter}
        />
        <Filter
          label="Status"
          options={["Active", "Lock", "Deleted"]}
          onFilter={setStatusFilter}
        />
      </div>
      <div className="account-manager-accounttable">
        <AccountTable
          accounts={filteredAccounts}
          onEdit={handleEditAccount}
          selectedAccounts={selectedAccounts}
          onSelectAccount={handleSelectAccount}
          onSelectAll={handleSelectAll}
        />
      </div>

      <div className="pagination">
        <button
          onClick={() => handlePageChange(currentPage - 1)}
          disabled={currentPage === 1}
          className="pagination-button"
        >
          &lt;
        </button>
        <span className="pagination-info">
          Page {currentPage} of {totalPages}
        </span>
        <button
          onClick={() => handlePageChange(currentPage + 1)}
          disabled={currentPage === totalPages}
          className="pagination-button"
        >
          &gt;
        </button>
      </div>

      <div className="account-manager-action">
        <Button
          rounded
          small
          onClick={() => {
            setSelectedAccount(null);
            setIsModalOpen(true);
          }}
        >
          Add
        </Button>
        <Button
          primary
          rounded
          small
          onClick={handleDelete}
          disabled={selectedAccounts.length === 0}
        >
          Delete
        </Button>
      </div>

      {isModalOpen && (
        <div className="modal-overlay">
          <Modal
            account={selectedAccount}
            onClose={handleModalClose}
            onSave={handleSave}
          />
        </div>
      )}
    </div>
  );
};

export default Account;
